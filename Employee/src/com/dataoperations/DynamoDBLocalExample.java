package com.dataoperations;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.net.URI;
import java.text.NumberFormat;
import java.util.Map;

import software.amazon.awssdk.regions.Region;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.List;
import java.util.Locale;

public class DynamoDBLocalExample {

	static NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);

	public static void main(String[] args) {
		// Cria o cliente do DynamoDB Local
		DynamoDbClient ddb = DynamoDbClient.builder().endpointOverride(URI.create("http://localhost:8000"))  
				.region(Region.US_EAST_1) // The region
				.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("dummyAccessKey", "dummySecretKey")))  
				.build();

		// Create table, insert and select registers.
		createTable(ddb);
		insertEmployees(ddb);
		queryEmployees(ddb);

		// Fecha o cliente
		ddb.close();
	}

	private static void createTable(DynamoDbClient ddb) {
		String tableName = "Employees";

		// Criação da tabela
		CreateTableRequest request = CreateTableRequest.builder().tableName(tableName)
				.keySchema(KeySchemaElement.builder().attributeName("EmployeeID").keyType(KeyType.HASH) // Key primary.
						.build())
				.attributeDefinitions(
						AttributeDefinition.builder().attributeName("EmployeeID").attributeType(ScalarAttributeType.N) // Type number.
								.build())
				.provisionedThroughput(ProvisionedThroughput.builder().readCapacityUnits(5L) // Read Capacity.
						.writeCapacityUnits(5L) // Write Capacity.
						.build())
				.build();

		try {
			ddb.createTable(request);
			System.out.println("Table created: " + tableName);
		} catch (ResourceInUseException e) {
			System.out.println("Table just exist: " + tableName);
		}
	}

	private static void insertEmployees(DynamoDbClient ddb) {
		String tableName = "Employees";

		// Adiciona registros na tabela
		PutItemRequest[] requests = new PutItemRequest[] {
				PutItemRequest.builder().tableName(tableName)
						.item(Map.of("EmployeeID", AttributeValue.builder().n("1").build(), "Name",
								AttributeValue.builder().s("John Smith").build(), "Department",
								AttributeValue.builder().s("Engineering").build(), "Salary",
								AttributeValue.builder().n("75000").build()))
						.build(),
				PutItemRequest.builder().tableName(tableName)
						.item(Map.of("EmployeeID", AttributeValue.builder().n("2").build(), "Name",
								AttributeValue.builder().s("Eric Hemsworth").build(), "Department",
								AttributeValue.builder().s("Marketing").build(), "Salary",
								AttributeValue.builder().n("65000").build()))
						.build(),
				PutItemRequest.builder().tableName(tableName)
						.item(Map.of("EmployeeID", AttributeValue.builder().n("3").build(), "Name",
								AttributeValue.builder().s("Bob Johnson").build(), "Department",
								AttributeValue.builder().s("Engineering").build(), "Salary",
								AttributeValue.builder().n("80000").build()))
						.build(),
				PutItemRequest.builder().tableName(tableName)
						.item(Map.of("EmployeeID", AttributeValue.builder().n("4").build(), "Name",
								AttributeValue.builder().s("Alice Williams").build(), "Department",
								AttributeValue.builder().s("Marketing").build(), "Salary",
								AttributeValue.builder().n("70000").build()))
						.build(),
				PutItemRequest.builder().tableName(tableName)
						.item(Map.of("EmployeeID", AttributeValue.builder().n("5").build(), "Name",
								AttributeValue.builder().s("Chris Evans").build(), "Department",
								AttributeValue.builder().s("Sales").build(), "Salary",
								AttributeValue.builder().n("55000").build()))
						.build() };

		// Execute todas as inserções
		for (PutItemRequest request : requests) {
			ddb.putItem(request);
			System.out.println("Insert Register: EmployeeID " + request.item().get("EmployeeID").n());
		}
	}

	private static void queryEmployees(DynamoDbClient ddb) {
		String tableName = "Employees";

		// Consulta todos os registros
		ScanRequest scanRequest = ScanRequest.builder().tableName(tableName).build();

		ScanResponse response = ddb.scan(scanRequest);
		List<Map<String, AttributeValue>> items = response.items();

		System.out.println("Registers found:");
		for (Map<String, AttributeValue> item : items) {
			System.out.println("EmployeeID: " + item.get("EmployeeID").n() + ", Name: " + item.get("Name").s()
					+ ", Department: " + item.get("Department").s() + ", Salary: " + item.get("Salary").n());
		}
	}
}

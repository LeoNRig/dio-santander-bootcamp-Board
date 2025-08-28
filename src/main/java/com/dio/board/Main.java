package com.dio.board;

import com.dio.board.persistence.migration.MigrationStrategy;

import static com.dio.board.persistence.config.ConnectionConfig.getConnection;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		try(var connection = getConnection()){
			new MigrationStrategy(connection).executeMigration();
		}
	}

}

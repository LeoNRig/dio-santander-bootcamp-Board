package com.dio.board.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.dio.board.persistence.dao.BoardColumnDAO;
import com.dio.board.persistence.dao.BoardDAO;
import com.dio.board.persistence.entity.BoardEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardService {

    private final Connection connection;

    public BoardEntity insert(final BoardEntity entity) throws SQLException {
        var dao = new BoardDAO(connection);
        var boardColumnDAO = new BoardColumnDAO(connection);
        try{
            dao.insert(entity);
            var columns = entity.getBoardColumn().stream().map(c ->{
                c.setBoard(entity);
                return c;
            }).toList();
            for (var column : columns){
                boardColumnDAO.insert(column);
            }
            connection.commit();
        }catch(SQLException e){
            connection.rollback();
            throw e;
        }
        return entity;
    }

    public boolean delete(final long id) throws SQLException{
        var dao = new BoardDAO(connection);
        try{
            if(!dao.exists(id)){
                return false;
            }
            dao.delete(id);
            connection.commit();
            return true;
        }catch(SQLException e){
            connection.rollback();
            throw e;
        }
    }

}

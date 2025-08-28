--liquibase formatted sql
--changeset junior:20250828
--comment: cards table create

CREATE TABLE CARDS(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    boards_columns_id BIGINT NOT NULL,
    CONSTRAINT boards_columns__cards_fk FOREIGN KEY (board_id) REFERENCES BOARDS(id)ON DELETE CASCADE
)ENGINE=InnoDB;

--rollback DROP TABLE CARDS
-- 사용자 테이블
CREATE TABLE user {

    id          BIGINT AUTO_INCREMENT                   NOT NULL,
    user_name   VARCHAR(4)                              NOT NULL,
    password    VARCHAR(100)                            NOT NULL,
    email       VARCHAR(100)                            NOT NULL,
    created_at  DATETIME DEFAULT CURRENT_TIMESTAMP()    NOT NULL,

    PRIMARY KEY (id)

};

-- 할일 테이블
CREATE TABLE todo {

    id          BIGINT AUTO_INCREMENT                   NOT NULL,
    title       VARCHAR(10)                             NOT NULL,
    contents    VARCHAR(200)                            NOT NULL,
    created_at  DATETIME DEFAULT CURRENT_TIMESTAMP()    NOT NULL,
    updated_at  DATETIME DEFAULT CURRENT_TIMESTAMP()    NOT NULL ON UPDATE CURRENT_TIMESTAMP(),

    PRIMARY KEY (id),
    CONSTRAINT fk__todo__user_id FOREIGN KEY (user_id) REFERENCES user(id)

};

-- 댓글 케이블
CREATE TABLE comment {

    id          BIGINT AUTO_INCREMENT                   NOT NULL,
    contents    VARCHAR(200)                            NOT NULL,
    created_at  DATETIME DEFAULT CURRENT_TIMESTAMP()    NOT NULL,
    updated_at  DATETIME DEFAULT CURRENT_TIMESTAMP()    NOT NULL ON UPDATE CURRENT_TIMESTAMP(),

    PRIMARY KEY (id),
    CONSTRAINT fk__comment__todo_id FOREIGN KEY (todo_id) REFERENCES todo(id),
    CONSTRAINT fk__comment__user_id FOREIGN KEY (user_id) REFERENCES user(id)

}



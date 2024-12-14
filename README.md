## API 명세

| 기능    | Method   | Path       | request                                                                                  | response                                                                                                                                                   |
|-------|----------|------------|------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 일정 생성 | `POST`   | /todo      | {<br/>user_id: Long,<br/>password: String,<br/>title: String,<br/>contents: String<br/>} | {<br/>id: Long,<br/>userId: Long,<br/>userName: String,<br/>title: String,<br/>contents: String,<br/>creatAt: LocalDateTime,<br/>updateAt: LocalDateTime } |
| 일정 조회 | `GET`    | /todo/{id} | -                                                                                        | {<br/>id: Long,<br/>userId: Long,<br/>userName: String,<br/>title: String,<br/>contents: String,<br/>creatAt: LocalDateTime,<br/>updateAt: LocalDateTime } |
| 일정 수정 | `PATCH`  | /todo/{id} | {<br/>password: String,<br/>title: String,<br/>contents: String<br/>}                    | {<br/>id: Long,<br/>userId: Long,<br/>userName: String,<br/>title: String,<br/>contents: String,<br/>creatAt: LocalDateTime,<br/>updateAt: LocalDateTime } |
| 일정 삭제 | `DELETE` | /todo/{id} | {<br/>password: String<br/>}                                                             | -                                                                                                                                                          |

## ERD 작성
![todolist-erd.png](todolist-erd.png)

## SQL 작성
[todo.sql](todo.sql)

-- 사용자 테이블


    id          BIGINT AUTO_INCREMENT                   NOT NULL,
    user_name   VARCHAR(4)                              NOT NULL,
    password    VARCHAR(100)                            NOT NULL,
    email       VARCHAR(100)                            NOT NULL,
    created_at  DATETIME DEFAULT CURRENT_TIMESTAMP()    NOT NULL,

    PRIMARY KEY (id)




-- 할일 테이블


    id          BIGINT AUTO_INCREMENT                   NOT NULL,
    title       VARCHAR(10)                             NOT NULL,
    contents    VARCHAR(200)                            NOT NULL,
    created_at  DATETIME DEFAULT CURRENT_TIMESTAMP()    NOT NULL,
    updated_at  DATETIME DEFAULT CURRENT_TIMESTAMP()    NOT NULL ON UPDATE CURRENT_TIMESTAMP(),

    PRIMARY KEY (id),
    CONSTRAINT fk__todo__user_id FOREIGN KEY (user_id) REFERENCES user(id)



-- 댓글 케이블


    id          BIGINT AUTO_INCREMENT                   NOT NULL,
    contents    VARCHAR(200)                            NOT NULL,
    created_at  DATETIME DEFAULT CURRENT_TIMESTAMP()    NOT NULL,
    updated_at  DATETIME DEFAULT CURRENT_TIMESTAMP()    NOT NULL ON UPDATE CURRENT_TIMESTAMP(),

    PRIMARY KEY (id),
    CONSTRAINT fk__comment__todo_id FOREIGN KEY (todo_id) REFERENCES todo(id),
    CONSTRAINT fk__comment__user_id FOREIGN KEY (user_id) REFERENCES user(id)




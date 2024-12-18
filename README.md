## API 명세

### 일정 API

| 기능       | Method   | Path        | query Param | request                                                           | response                                                                                                                                 |
|----------|----------|-------------|-------------|-------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------|
| 일정 생성    | `POST`   | /todos      |             | {<br/>userId: Long,<br/>title: String,<br/>contents: String<br/>} | {<br/>id: Long,<br/>userName: String,<br/>title: String,<br/>contents: String,<br/>creatAt: LocalDateTime,<br/>updateAt: LocalDateTime } |
| 일정 조회    | `GET`    | /todos/{id} |             | -                                                                 | {<br/>id: Long,<br/>userName: String,<br/>title: String,<br/>contents: String,<br/>creatAt: LocalDateTime,<br/>updateAt: LocalDateTime } |
| 일정 목록 조회 | `GET`    | /todos      | size, page  |                                                                   | [<br/>{todoResponseDto},<br/>{todoResponseDto},<br/>{todoResponseDto}<br/>]                                                              |
| 일정 수정    | `PUT`    | /todos/{id} |             | {<br/>title: String,<br/>contents: String<br/>}                   | {<br/>id: Long,<br/>userName: String,<br/>title: String,<br/>contents: String,<br/>creatAt: LocalDateTime,<br/>updateAt: LocalDateTime } |
| 일정 삭제    | `DELETE` | /todos/{id} |             | -                                                                 | -                                                                                                                                        |


### 유저 API

| 기능               | Method   | Path             | request                                                               | response                                                                                                           |
|------------------|----------|------------------|-----------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|
| 회원가입<br/>(유저 생성) | `POST`   | /api/auth/signup | {<br/>userName: String,<br/>email: String,<br/>password: String<br/>} | {<br/>id: Long,<br/>userName: String,<br/>email: String<br/>creatAt: LocalDateTime,<br/>updateAt: LocalDateTime}   |
| 로그인              | `GET`    | /api/auth/login  | {<br/>email: String,<br/>password: String<br/>}                       | {<br/>email: String<br/>sessionId: String<br/>}                                                                    |
| 유저 조회            | `GET`    | /users/{id}      | -                                                                     | {<br/>id: Long,<br/>userName: String,<br/>email: String,<br/>creatAt: LocalDateTime,<br/>updateAt: LocalDateTime } |
| 유저 수정            | `PUT`    | /users/{id}      | {<br/>userName: String<br/>}                                          | {<br/>id: Long,<br/>userName: String,<br/>email: String,<br/>creatAt: LocalDateTime,<br/>updateAt: LocalDateTime } |
| 유저 삭제            | `DELETE` | /uesrs/{id}      | {<br/>password: String<br/>}                                          | -                                                                                                                  |

### 댓글 API

| 기능    | Method   | Path           | request                                                          | response                                                                                                                                |
|-------|----------|----------------|------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| 댓글 생성 | `POST`   | /comments      | {<br/>todoId: Long,<br/>userId: Long,<br/>contents: String<br/>} | {<br/>id: Long,<br/>todoId: Long,<br/>userId: Long,<br/>contents: String,<br/>creatAt: LocalDateTime,<br/>updateAt: LocalDateTime<br/>} |
| 댓글 조회 | `GET`    | /comments/{id} | -                                                                | {<br/>id: Long,<br/>todoId: Long,<br/>userId: Long,<br/>contents: String,<br/>creatAt: LocalDateTime,<br/>updateAt: LocalDateTime<br/>  |
| 댓글 수정 | `PUT`    | /comments/{id} | {<br/>contents: String<br/>}                                     | {<br/>id: Long,<br/>todoId: Long,<br/>userId: Long,<br/>contents: String,<br/>creatAt: LocalDateTime,<br/>updateAt: LocalDateTime<br/>  |
| 댓글 삭제 | `DELETE` | /comments/{id} | -                                                                | -                                                                                                                                       |

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




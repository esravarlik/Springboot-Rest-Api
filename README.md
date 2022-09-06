# SpringbootRestApi


### Dependencies;
- Spring Boot DevTools
- Lombok
- H2 Database
- Spring Data JPA
- Spring Web


![user drawio](https://user-images.githubusercontent.com/40757395/188591268-61d00750-7b8b-4c41-8f27-9783d3605478.png)


### Layered Architecture;
- advice
  - ControllerExceptionHandler
  - ExceptionResponse
  - UserNotFound
- config
  - ModelMapperConfig
- controller
  - UserController
- dto
  - UserDto
- entity
  - BaseEntity
  - User
- repository
  - UserRepository
- service
  - imp
    - UserServiceImpl
  - UserService
- util
  - CustomPage

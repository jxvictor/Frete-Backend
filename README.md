# Estudo pessoal
Atualmente em atualizações para compatibilidade com o frontend.

## Spring Boot

Implementação do endpoint para o cálculo do preço do frete.

```
http://localhost:8080/entrega
```

## Observações

Projeto utilizado usando o Mysql Workbench, em caso de teste utilizando o mesmo, alterar o application.properties para a configuração de acordo com os seus dados.
Segue abaixo um exemplo:

```
## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url=jdbc:mysql://localhost:3306/sigabem?useSSL=false
spring.datasource.username=root
spring.datasource.password=123321

# Dialeto SQL melhorar o SQL gerado pelo Hibernate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto=update
```

## Exemplos POST

```
{
    "peso": 50.00,
    "cepOrigem": {"cep": "20550162"},
    "cepDestino": {"cep": "58125970"},
    "nomeDestinatario": "Alves"
}
```
```
{
    "peso": 30.02,
    "cepOrigem": {"cep": "20550162"},
    "cepDestino": {"cep": "23900050"},
    "nomeDestinatario": "Victor"
}
```
```
{
    "peso": 50.98,
    "cepOrigem": {"cep": "58406060"},
    "cepDestino": {"cep": "58135-000"},
    "nomeDestinatario": "Joao"
}
```

## Swagger
```
http://localhost:8080/swagger-ui.html
```

## Observação Swagger

Colocar no application.properties a linha abaixo:

```
spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
```

## Contato

```
https://www.linkedin.com/in/joao-victor-costa-alves/
```

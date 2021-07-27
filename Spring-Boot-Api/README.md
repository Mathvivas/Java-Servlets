<center>
    <h1>API Fórum Spring Boot</h1>
</center>

<br>
<br>

# Sobre o Projeto

<br>

- Projeto realizado na Formação Spring Boot da Alura;
- API do Fórum da Alura.

<br>

# Deploy

<br>

- Criar o jar da aplicação pelo terminal (na raíz do projeto):

<br>

```bash
mvn clean package
```

<br>

- Para rodar o jar:

<br>

```bash
cd target
ls
java -jar ${nomeDoArquivoJar}.jar
```
<br>

- Para rodar o jar em algum profile (Ex: produção):

<br>

```bash
cd target
ls
java -jar -Dspring.profiles.active=${profile} ${nomeDoArquivoJar}.jar
```

<br>

- Para rodar o jar informando variáveis de ambiente colocadas no <b>application.properties</b>

<br>

```bash
java -jar -Dspring.profiles.active=${profile}
-DFORUM_DATABASE_URL=jdbc:mysql://localhost:3306/forum
-DFORUM_DATABASE_USERNAME=${username} 
-DFORUM_DATABASE_PASSWORD=${password} 
-DFORUM_JWT_SECRET=${secret} 
${nomeDoArquivoJar}.jar
```

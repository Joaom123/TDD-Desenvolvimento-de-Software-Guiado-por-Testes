# Quebra de Strings com CamelCase
Projeto Prático da Semana 1 do Curso TDD - Desenvolvimento de Software Guiado por Testes

Criar um método que transforma uma cadeia de caracteres em camel case em uma lista de Strings com as palavras.\
O método deve possuir a seguinte assinatura: "public static List<String> converterCamelCase(String original)".

## Requisitos
- nome - “nome”
- Nome - “nome”
- nomeComposto - “nome”, “composto”
- NomeComposto - “nome”, “composto”
- CPF - “CPF”
- numeroCPF - “numero”, “CPF”
- numeroCPFContribuinte - “numero”, “CPF”, “contribuinte”
- recupera10Primeiros - “recupera”, “10”, “primeiros”
- 10Primeiros - Inválido → não deve começar com números
- nome#Composto - Inválido → caracteres especiais não são permitidos, somente letras e números

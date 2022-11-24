#language:pt

Funcionalidade: Teste login Bugbank

  @test
  Cenario: Login com sucesso
    Dado que eu esteja na pagina inicial:"http://localhost:3000"
    E possua um cadastro com os dados
      | Email             | Nome       | Senha  | Confirmacao |
      | teste@teste.com   | Jaqueline  | 123456 | 123456      |
      | teste10@teste.com | Emerson 30 | 456789 | 45678       |
      | teste20@teste.com | Emerson 40 | 987654 | 987654      |
    Quando eu preencher email:"teste@teste.com" e senha:"123456"
    E clicar em fazer login
    Entao valido que a pagina de boas vindas foi carregada

  @test
  Cenario: Login com falha
    Dado que eu esteja na pagina inicial:"http://localhost:3000"
    E possua um cadastro com os dados
      | Email             | Nome       | Senha  | Confirmacao |
      | teste@teste.com   | Emerson    | 123456 | 123456      |
      | teste10@teste.com | Emerson 10 | 456789 | 456789      |
      | teste20@teste.com | Emerson 20 | 987654 | 987654      |
    Quando eu preencher email:"teste@teste.com" e senha:"123456"
    E clicar em fazer login
    Entao valido que a pagina de boas vindas foi carregada

#  @test
#  Cenario: Login com erro de senha
#    Dado que eu esteja na pagina inicial:"http://localhost:3000"
#    E possua um cadastro com os dados
#      | Email             | Nome       | Senha  | Confirmacao |
#      | teste@teste.com   | Emerson    | 123456 | 123456      |
#      | teste10@teste.com | Emerson 10 | 456789 | 456789      |
#      | teste20@teste.com | Emerson 20 | 987654 | 987654      |
#    Quando eu preencher email:"teste@teste.com" e senha:"1234567"
#    E clicar em fazer login
#    Entao valido que a mensagem senhas não conferem
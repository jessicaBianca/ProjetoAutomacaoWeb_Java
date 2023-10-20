#author: Jessica Oliveira

  Feature: Login do Site Sauce Demo

  #US001 - Login bem-sucedido no site ecommerce da saucedemo

    #Como um cliente em busca de produtos e ofertas incríveis,
    #Eu quero fazer login com sucesso no site ecommerce
    #Para que eu possa navegar no site, adicionar produtos ao meu carrinho e finalizar minhas compras de forma conveniente.

    @logar @CT001-Login @logar_standard_user
    Scenario: Logar com sucesso no site com o standard user
      Given que acesso o sauce demo
      When digito "standard_user" e senha
      And clico em login
      Then acesso a página de produtos com sucesso

    @logar @CT002-Login @logar_performance_user
    Scenario: Logar com sucesso no site com o performance_user
      Given que acesso o sauce demo
      When digito "performance_user" e senha
      And clico em login
      Then acesso a página de produtos com sucesso

    @logar @CT003-Login @problem_user
    Scenario: Logar com sucesso no site com o problem_user
      Given que acesso o sauce demo
      When digito "problem_user" e senha
      And clico em login
      Then acesso a página de produtos com sucesso

    @logar @CT004-Login @locked_user
    Scenario: Validar mensagem de que o usuario esta bloqueado
      Given que acesso o sauce demo
      When digito "locked_user" e senha
      And clico em login
      Then valido a mensagem "Epic sadface: Sorry, this user has been locked out." em tela









O dono de uma empresa estava montado sua loja ecommerce para alavancar seus negócios. Esse dono acabou descobrindo que seu sobrinho estava na faculdade de tecnologia e estava desenvolvendo aplicações a um custo muito abaixo do mercado. Afim de economizar um bom dinheiro passou a demanda para seu sobrino que consistia em montar uma aplicação Back-End para registro de clientes e notas. Seu sobrinho ficou alguns meses trabalhando no projeto e acabou abandonando na metade, porem disse que o cadastro de clientes estava funcionando 100%. Seu tio ao ver o resultado notou que aplicação perdia todos os registros quando precisava reiniciar o projeto, ele contratou a wBrain para finalizar o projeto, nosso ponto de partida é o projeto atual, sendo assim temos algumas missões:
- Entender porque a aplicação esta perdendo os dados toda vez que reinicia.
- O cliente gostaria de ter uma base local para realizar testes, demos como sugestão ter um docker-compose no projeto.
- Devemos incluir também uma feature que irá permitir lançar notas (codigo, data, cliente, valor), consultar notas, excluir notas e atualizar notas
- Cliente deseja também dois relatorios, para isso precisaremos disponibilizar duas apis para ele, uma que retorne o valor vendido para cada cliente e outra com total que foi vendido por mês.
- Devemos aplicar melhorias no projeto para que ele esteja mais desacoplado e uma arquitetura mais clean-arch.
- Devemos garantir garantir também a qualidade do projeto via testes unitários
- Também será necessário migrar o gerenciador de dependencias de Mavem para Gradle.
- Documentação das API's seria um diferencial.
- Esta empresa esta integrando sua API de clientes com outra empresa e essa empresa insiste que o body da request precisa ser enviada da forma abaixo, precisamos também ver uma forma de realizar isso do melhor jeito:
`    {
  "seu_codigo": 1,
  "nome_da_pessoa": "Nome do cliente",
  "cpf_documento": "000000000000",
  "telefone_contato_pessoa": "4565"
  }`
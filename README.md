# Proffy Mobile - Desafio: Fluxo de Recuperação de Senha

* **Nome Completo:** [Ludmyla Dutra de Queiroz]
* **Turma:** [6 Periodo]

### Sobre a Implementação
Implementei a tela `ForgotPasswordActivity` seguindo rigorosamente os padrões visuais e arquiteturais do projeto base. A validação do e-mail é feita de forma reativa através de um `TextWatcher`, exibindo mensagem de erro dinâmica e alterando o estado do botão inferior entre cinza ("Entrar", desabilitado) e verde ("Enviar", habilitado) apenas quando o formato do e-mail é correto. Após o envio válido, o usuário é redirecionado com segurança para a tela existente `FinallyActivity` utilizando uma Intent.
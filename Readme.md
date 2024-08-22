# Simulação de Algoritmos de Escalonamento - Sistemas Operacionais

## Descrição

Este projeto tem como objetivo a implementação e simulação de diferentes algoritmos de escalonamento de processos, como parte das atividades da disciplina de Sistemas Operacionais do curso de Bacharelado em Ciência da Computação do IFCE. Foram desenvolvidos os algoritmos **Shortest Job First (SJF)** e **Priority First**, permitindo uma análise comparativa entre ambos.

## Algoritmos Implementados

1. **Shortest Job First (SJF)**
   - Implementação base para o projeto.
   - Prioriza os trabalhos com menor tempo de execução, minimizando o tempo de resposta.

2. **Priority First**
   - Implementação que lida com processos de diferentes prioridades.
   - Garante que processos com maior prioridade sejam executados antes, gerenciando de forma eficaz os recursos do sistema.

## Simulações

As simulações realizadas utilizam um conjunto de requisições adequado para analisar e comparar os algoritmos em termos de:
- **Tempo de espera**: Tempo até que o algoritmo entre em execução.
- **Tempo de turnaround**: Tempo total até que o processo seja executado e finalizado.
- **Utilização de CPU e memória**.

## Resultados

Os resultados são tabulados e discutidos, focando em:
- **Tempo médio de espera**.
- **Tempo médio de turnaround**.
- **Eficiência do uso da CPU e memória**.

## Estrutura do Projeto


| Diretório/Arquivo | Descrição | 
|----------|----------|
| src/   | Contém os arquivos fonte do projeto.  |
| pom.xml  | Arquivo de configuração do Maven.  |
|README.md | Este arquivo, com informações básicas e instruções sobre o projeto. |
  |

## Contribuições
### Contribuições são bem-vindas! Para contribuir com este projeto, siga estes passos:

- **Fork este repositório.**
- **Crie um novo branch para sua feature.**
- **Faça as suas alterações e commit.**
- **Envie um pull request.**

## Licença
#### Este projeto está licenciado sob a licença MIT.  

## Autores

- ### José Luciano Martins Neto.
- ### José Breno Cardoso Duarte.
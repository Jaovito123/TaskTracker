# Task Tracker

Task Tracker é uma aplicação de linha de comando (CLI) para gerenciar tarefas.

## Instalação

1. Certifique-se de ter o **Java 17+** instalado.
2. Baixe o **task-tracker.jar** ou compile o projeto usando Maven:
   ```sh
   mvn clean package
   ```
3. Para facilitar o uso, crie um alias global no seu **~/.bashrc** ou **~/.zshrc**:
   ```sh
   alias task-tracker='java -jar /caminho/para/task-tracker.jar'
   ```
4. Reinicie o terminal ou execute:
   ```sh
   source ~/.bashrc  # ou source ~/.zshrc
   ```

## Uso

Execute o comando:
```sh
java -jar task-tracker.jar <comando> [argumentos]
```
Ou, se criou o alias:
```sh
task-tracker <comando> [argumentos]
```

### Comandos Disponíveis

- `add <descrição>` - Adiciona uma nova tarefa.
- `list` - Lista todas as tarefas.
- `update-description <id> <descrição>` - Atualiza a descrição de uma tarefa.
- `update-status <id> <status>` - Atualiza o status de uma tarefa.
    - **Status disponíveis:** `done`, `in-progress`.
- `delete <id>` - Deleta uma tarefa.
- `help` - Exibe a ajuda.
- `version` - Exibe a versão do aplicativo.

### Exemplos

Adicionar uma tarefa:
```sh
java -jar task-tracker.jar add "Estudar Java"
```

Listar todas as tarefas:
```sh
java -jar task-tracker.jar list
```

Atualizar descrição de uma tarefa:
```sh
java -jar task-tracker.jar update-description 1 "Revisar POO"
```

Marcar uma tarefa como concluída:
```sh
java -jar task-tracker.jar update-status 1 done
```

Deletar uma tarefa:
```sh
java -jar task-tracker.jar delete 1
```

## Licença

Este projeto está licenciado sob a [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).


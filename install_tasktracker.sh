DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
if [ -f "$HOME/.bashrc" ]; then
    echo "alias tasktracker='java -jar $DIR/target/TaskTracker-1.0-SNAPSHOT.jar'" >> "$HOME/.bashrc"
    source "$HOME/.bashrc"
elif [ -f "$HOME/.zshrc" ]; then
    echo "alias tasktracker='java -jar $DIR/target/TaskTracker-1.0-SNAPSHOT.jar'" >> "$HOME/.zshrc"
    source "$HOME/.zshrc"
fi
echo "Alias 'tasktracker' criado com sucesso!"

public class Actor {
    private String name;
    private String characterName;

    public Actor(String name, String characterName){
        this.name = name;
        this.characterName = characterName;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void printActor(){
        System.out.println("Actor Name: "+name);
        System.out.println("Character: "+characterName);
    }
}

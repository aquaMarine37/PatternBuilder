public class Main {

    public static void main(String[] args) {
        Person mother = new PersonBuilder()
                .setName("Ольга")
                .setSurname("Иванова")
                .setAge(27)
                .setAddress("Москва")
                .build();
        Person son = mother.newChildBuilder()
                .setName("Кирюша")
                .build();
        System.out.println("У " + mother + " есть сын, " + son);

        try {
            // не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}

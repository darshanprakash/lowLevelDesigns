public class ExampleSubscriber implements Subscriber {
    private String name;

    public ExampleSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void receive(Message message) {
        System.out.println(name + " received: " + message.getContent());
    }
}

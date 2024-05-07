public class PubSubMain {
    public static void main(String[] args) {
        PubSubService pubSubService = new PubSubService();

        // Create subscribers
        Subscriber subscriber1 = new ExampleSubscriber("Subscriber 1");
        Subscriber subscriber2 = new ExampleSubscriber("Subscriber 2");

        // Subscribe to topics
        pubSubService.subscribe("sports", subscriber1);
        pubSubService.subscribe("tech", subscriber2);
        pubSubService.subscribe("sports", subscriber2);

        // Create a publisher and publish messages
        Publisher publisher = new Publisher();
        publisher.publish(pubSubService, "sports", "Sports News Here!");
        publisher.publish(pubSubService, "tech", "Tech News Here!");
    }
}

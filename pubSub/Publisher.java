public class Publisher {
    public void publish(PubSubService pubSub, String topic, String content) {
        Message message = new Message(topic, content);
        pubSub.publish(message);
    }
}

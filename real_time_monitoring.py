from kafka import KafkaConsumer
import json

class RealTimeMonitor:
    def __init__(self, topic):
        self.consumer = KafkaConsumer(
            topic,
            bootstrap_servers='localhost:9092',
            auto_offset_reset='earliest',
            enable_auto_commit=True,
            value_deserializer=lambda x: json.loads(x.decode('utf-8'))
        )

    def start_monitoring(self):
        for message in self.consumer:
            print(f"Received message: {message.value}")
            # Add risk analysis logic here

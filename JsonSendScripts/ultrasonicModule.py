import boto3
import json
import random
import os
import time
import datetime 

url = os.environ.get("url")
sqs = boto3.client('sqs', region_name='us-east-1')
time_to_sleep = os.environ.get("time_to_sleep")

while(1):
    data = {
        "value": random.randint(1, 60),
        "time":   datetime.datetime.now().isoformat(),
        "type": "ultrasonicModule",
        "latitude": random.randint(-90, 90),
        "longitude": random.randint(-180, 180)
    }

    response = sqs.send_message(QueueUrl=url,  MessageBody=json.dumps(data))

    if response['ResponseMetadata']['HTTPStatusCode'] == 200:
        print("JSON sent successfully")
    else:
        print(response)
        break
    time.sleep(float(time_to_sleep))




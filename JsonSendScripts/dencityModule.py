import boto3
import json
import random
import os
import time
import datetime 

url = os.environ.get("url")
time_to_sleep = os.environ.get("time_to_sleep")
sqs = boto3.client('sqs', region_name='us-east-1')

while(1):
    data = {
        "value": random.randint(1, 2000),
        "time": datetime.datetime.now().isoformat(),
        "type": "dencityModule",
        "latitude": random.randint(-90, 90),
        "longitude": random.randint(-180, 180)
    }


    response = sqs.send_message(QueueUrl=url,  MessageBody=json.dumps(data))
    print(response)

    if response['ResponseMetadata']['HTTPStatusCode'] == 200:
        print("JSON sent successfully")
    else:
        print(response)
        break
    time.sleep(float(time_to_sleep))


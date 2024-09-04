from azure.cognitiveservices.vision.computervision import ComputerVisionClient
from azure.cognitiveservices.vision.computervision.models import OperationStatusCodes
from msrest.authentication import CognitiveServicesCredentials

subscription_key = 'your_subscription_key'
endpoint = 'your_endpoint'

computervision_client = ComputerVisionClient(endpoint, CognitiveServicesCredentials(subscription_key))

def read_text(image_path):
    with open(image_path, "rb") as image_stream:
        poller = computervision_client.read_in_stream(image_stream, raw=True)
        result = poller.result()

    operation_location = result.headers["Operation-Location"]
    operation_id = operation_location.split("/")[-1]

    result = computervision_client.get_read_result(operation_id)

    if result.status == OperationStatusCodes.succeeded:
        for page_result in result.analyze_result.read_results:
            for line in page_result.lines:
                print(f"Detected text: {line.text}")

# Replace 'your-image.jpg' with the path to your image
read_text('C:/Users/Jeevitha R/Pictures/Screenshots/Screenshot (49).png')
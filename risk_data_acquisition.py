import requests

class RiskDataAcquisition:
    def __init__(self, api_url):
        self.api_url = api_url

    def fetch_risk_data(self):
        response = requests.get(self.api_url)
        if response.status_code == 200:
            return response.json()
        else:
            raise Exception(f"Failed to fetch risk data: {response.status_code}")

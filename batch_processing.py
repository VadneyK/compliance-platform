import pandas as pd
import re

class BatchProcessor:
    def __init__(self, data):
        self.data = data

    def scan_ofac_violations(self):
        # Example: Check for OFAC violations
        ofac_list = ['OFAC_VIOLATION_1', 'OFAC_VIOLATION_2']
        return self.data[self.data['transaction'].isin(ofac_list)]

    def scan_native_characters(self):
        # Example: Scan for native characters
        native_char_pattern = re.compile(r'[\u4e00-\u9fff]')  # Chinese characters
        return self.data[self.data['transaction'].apply(lambda x: bool(native_char_pattern.search(x)))]

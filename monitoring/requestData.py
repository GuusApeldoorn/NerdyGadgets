import requests

r = requests.post("http://192.168.1.130:80/status.txt")
print(r.content)

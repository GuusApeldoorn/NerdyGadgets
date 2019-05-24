import os
import psutil
import time
import requests
import json
import socket
from requests.exceptions import HTTPError

name = "loadbalancer"
used = 0
free = 0
uptime_minutes = 0
cpu = 0
timestamp = int(time.time())

servers = ["http://192.168.1.2:80/data.json","http://192.168.1.3:80/data.json","http://192.168.2.3:80/data.json","http://192.168.2.4:80/data.json"]

def disk_usage(path):
    global used
    global free
    st = os.statvfs(path)
    free = st.f_bavail * st.f_frsize / 1000000000
    used = (st.f_blocks - st.f_bfree) * st.f_frsize / 1000000000

def uptime():
    global uptime_minutes
    with open('/proc/uptime', 'r') as f:
        uptime_seconds = float(f.readline().split()[0])
        uptime_minutes = round(uptime_seconds/60, 2)

while True:
    i = 0
    data = []

    cpu = psutil.cpu_percent(interval=1)
    disk_usage("/")
    uptime()
    timestamp = int(time.time())

    thisdata = {
        "timestamp": timestamp,
        "uptime": uptime_minutes,
        "disk_used": used,
        "disk_free": free,
        "cpu": cpu,
        "name": name
    }

    for url in servers:
        try:
            r = requests.get(url, timeout=0.2)

            # If the response was successful, no Exception will be raised
            r.raise_for_status()

            sData = json.loads(r.content)
            data.append(sData)
        except HTTPError:
            print('F')
            continue
        except Exception as err:
            print('F')
            print(err)
            continue
        else:
            print('Success!')

    data.append(thisdata)
    print (data)

    with open('/var/www/html/data.json', 'w') as outfile:
        json.dump(data, outfile)

    time.sleep(1)

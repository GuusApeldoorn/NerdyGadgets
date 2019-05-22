import os
import psutil
import time
import requests
import json
import socket

name = "web1"
used = 0
free = 0
uptime_minutes = 0
cpu = 0

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
    cpu = psutil.cpu_percent(interval=1)
    disk_usage("/")
    uptime()
    timestamp = int(time.time())
    data = {
        "timestamp": timestamp,
        "uptime": uptime_minutes,
        "disk_used": used,
        "disk_free": free,
        "cpu": cpu,
        "name": name
    }
    with open('/var/www/html/data.json', 'w') as outfile:
        json.dump(data, outfile)

    time.sleep(1)

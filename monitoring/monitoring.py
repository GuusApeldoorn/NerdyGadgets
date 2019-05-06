import os
import psutil
import time
import requests

total = 0
reserved = 0
used = 0
free = 0
uptime_minutes = 0
cpu = 0

def disk_usage(path):
    global total
    global reserved
    global used
    global free
    st = os.statvfs(path)
    free = st.f_bavail * st.f_frsize / 1000000000
    total = st.f_blocks * st.f_frsize / 1000000000
    used = (st.f_blocks - st.f_bfree) * st.f_frsize / 1000000000
    reserved = total - used - free
    print "Tot. disk: %s GB" % (total)
    print "Res. disk: %s GB" % (reserved)
    print "Used disk: %s GB" % (used)
    print "Free disk: %s GB" % (free)

def uptime():
    global uptime_minutes
    with open('/proc/uptime', 'r') as f:
        uptime_seconds = float(f.readline().split()[0])
        uptime_minutes = round(uptime_seconds/60, 2)
        print "Uptime: %s minutes" % (uptime_minutes)

while True:
    cpu = psutil.cpu_percent(interval=2)
    print "======"
    disk_usage("/")
    uptime()
    print "CPU load: %s perc." % (cpu)
    f= open("/var/www/html/status.txt","w+")
    f.write("%s %s %s %s %s %s" % (total, reserved, used, free, uptime_minutes, cpu))
    time.sleep(1)

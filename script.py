#!/usr/bin/env python3
import csv

delimiter = '*'

def getlines():
    with open('movies.csv', newline='') as f:
        reader = csv.reader(f, delimiter=',', quotechar='"')
        for row in reader:
            yield row

def parse_runtime(runtime):
    thing = runtime.split(' ')
    hours = int(thing[0][:-1])
    minutes = 0
    try:
        minutes = int(thing[1][:-1])
    except IndexError:
        pass
    return str(hours * 60 + minutes)

splitted = list(getlines())[1:]
entries = []
for entry in splitted:
    name = entry[1]
    year = entry[2]
    try:
        runtime = parse_runtime(entry[6])
    except ValueError:
        continue
    actors = entry[10].split(',')
    actor1 = actors[0]
    actor2 = actors[1]
    director = entry[11].split(',')[0] if ',' in entry[11] else entry[11]
    entries.append(delimiter.join([name, year, runtime, actor1, actor2, director]))

res = '\n'.join(entries)
print(res)

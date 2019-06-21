import sys
import csv

argc = len(sys.argv)
usage = "Usage: python database.py location (eg: python database.py d:/dash/file.csv)"

if argc == 1:
    print(usage)
    exit(1)

location = sys.argv[1]

try:
    with open(location, "r") as csv_file:
        with open("new.csv", "w") as new_file:
            csv_reader = csv.reader(csv_file)
            next(csv_reader)
            next(csv_reader)
            
            for row in csv_reader:
                new_row = row[:11] + row[12:23]
                new_row[17] = new_row[17][:10]
                new_row[18] = new_row[18][:10]
                new_row[21] = new_row[21][:10]
                
                string = ""
                element_count = 0
                for element in new_row:
                    if element_count != 0:
                        string += ","
                    string += "\"" + element + "\""
                    element_count+=1
                string += "\n"

                new_file.write(string)
except Exception as identifier:
    print("The file you provided does not exist")

        

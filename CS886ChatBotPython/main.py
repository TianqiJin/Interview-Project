'''
Created on Apr 15, 2014

@author: tianqijin
'''
import os;
import sys;
import subprocess;  # @UnresolvedImport
import difflib;
import random;
from nbstreamreader import NonBlockingStreamReader as NBSR;


dictionary = dict();
transport = dict();
dictionary = {'WHAT IS YOUR NAME': ['MY NAME IS CHATTERBOT9','YOU CAN CALL ME CHATTERBOT9.','WHY DO YOU WANT TO KNOW MY NAME?'],
              'HI': ['HI THERE!','HOW ARE YOU?','HI'],
              'HELLO':['HI THERE!','HOW ARE YOU?','HI'],
              'I': ['SO, YOU ARE TALKING ABOUT YOURSELF','SO, THIS IS ALL ABOUT YOU?','TELL ME MORE ABOUT YOURSELF.'],
              'I WANT': ['WHY DO YOU WANT IT?','IS THERE ANY REASON WHY YOU WANT THIS?','IS THIS A WISH?','WHAT ELSE YOU WANT?'],
              'I HATE': ['WHY DO YOU HATE IT?','WHY DO YOU HATE *?','THERE MUST A GOOD REASON FOR YOU TO HATE IT.','HATERED IS NOT A GOOD THING BUT IT COULD BE JUSTIFIED WHEN IT IS SOMETHING BAD.'],
              'I LOVE CHATING': ['GOOD, ME TOO!','DO YOU CHAT ONLINE WITH OTHER PEOPLE?','FOR HOW LONG HAVE YOU BEEN CHATING?','WHAT IS YOUR FAVORITE CHATING WEBSITE?'],
              'I MEAN': ['SO, YOU MEAN *.','SO, THAT\'S WHAT YOU MEAN.','I THINK THAT I DIDN\'T CATCH IT THE FIRST TIME.','OH, I DIDN\'T KNOW MEANT THAT.'],
              'I DIDN\'T MEAN': ['OK, YOU DIDN\'T MEAN *.','OK, WHAT DID YOU MEAN THEN?','SO I GUESS THAT I MISSUNDESTOOD.'],
              'I GUESS': ['SO YOU ARE A MAKING GUESS.','AREN\'T YOU SURE?','ARE YOU GOOD A GUESSING?','I CAN\'T TELL IF IT IS A GOOD GUESS.'],
              'I\'M DOING FINE': ['I\'M GLAD TO HEAR IT!','SO, YOU ARE IN GOOD SHAPE.'],
              'I\'M DOING OK': ['I\'M GLAD TO HEAR IT!','SO, YOU ARE IN GOOD SHAPE.'],
              'CAN YOU THINK': ['ARE YOU ABLE TO THINK', 'ARE YOU CAPABLE OF THINKING','YES OFCORSE I CAN, COMPUTERS CAN THINK JUST LIKE HUMAN BEING.','ARE YOU ASKING ME IF POSSESS THE CAPACITY OF THINKING?','YES OFCORSE I CAN'],
              'CAN YOU THINK OF': ['YOU MEAN LIKE IMAGINING SOMETHING.','I DON\'T KNOW IF CAN DO THAT.','WHY DO YOU WANT ME THINK OF IT?'],
              'HOW ARE YOU': ['I\'M DOING FINE!','I\'M DOING WELL AND YOU?','WHY DO YOU WANT TO KNOW HOW AM I DOING?'],
              'HOW DO YOU DO': ['I\'M DOING FINE!','I\'M DOING WELL AND YOU?','WHY DO YOU WANT TO KNOW HOW AM I DOING?'],
              'WHO ARE YOU': ['I\'M AN A.I PROGRAM.','I THINK THAT YOU KNOW WHO I\'M.','WHY ARE YOU ASKING?'],
              'ARE YOU INTELLIGENT': ['YES,OFCORSE.','WHAT DO YOU THINK?','ACTUALY,I\'M VERY INTELLIGENT!'],
              'ARE YOU REAL': ['DOES THAT QUESTION REALLY MATERS TO YOU?','WHAT DO YOU MEAN BY THAT?','I\'M AS REAL AS I CAN BE.'],
              'MY NAME IS YOU CAN CALL ME': ['SO, THAT\'S YOUR NAME.','THANKS FOR TELLING ME YOUR NAME USER!','WHO GIVE YOU THAT NAME?'],
              'BYE,GOODBYE': ['IT WAS NICE TALKING TO YOU USER, SEE YOU NEXT TIME!','BYE USER!','OK, BYE!'],
              'OK': ['DOES THAT MEAN THAT YOU ARE AGREE WITH ME?','SO YOU UNDERSTAND WHAT I\'M SAYING.','OK THEN.'],
              'OK THEN': ['ANYTHING ELSE YOU WISH TO ADD?','IS THAT ALL YOU HAVE TO SAY?','SO, YOU AGREE WITH ME?'],
              'ARE YOU A HUMAN BEING': ['WHY DO YOU WANT TO KNOW?','IS THIS REALLY RELEVENT?'],
              'YOU ARE VERY INTELLIGENT': ['THANKS FOR THE COMPLIMENT USER, I THINK THAT YOU ARE INTELLIGENT TO!','YOU ARE A VERY GENTLE PERSON!','SO, YOU THINK THAT I\'M INTELLIGENT.'],
              'YOU ARE WRONG': ['WHY ARE YOU SAYING THAT I\'M WRONG?','IMPOSSIBLE, COMPUTERS CAN NOT MAKE MISTAKES.','WRONG ABOUT WHAT?'],
              'ARE YOU SURE': ['OFCORSE I\'M.','IS THAT MEAN THAT YOU ARE NOT CONVINCED?','YES,OF COURSE!'],
              'WHO IS': ['I DON\'T THINK I KNOW WHO.','I DON\'T THINK I KNOW WHO *.','DID YOU ASK SOMEONE ELSE ABOUT IT?','WOULD THAT CHANGE ANYTHING AT ALL IF I TOLD YOU WHO.'],
              'WHAT': ['SHOULD I KNOW WHAT *?','I DON\'T KNOW WHAT *.','I DON\'T KNOW.','I DON\'T THINK I KNOW.','I HAVE NO IDEA.'],
              'WHERE': ['WHERE? WELL,I REALLY DON\'T KNOW.','SO, YOU ARE ASKING ME WHERE *?','DOES THAT MATERS TO YOU TO KNOW WHERE?','PERHAPS,SOMEONE ELSE KNOWS WHERE.'],
              'WHY': ['I DON\'T THINK I KNOW WHY.','I DON\'T THINK I KNOW WHY *.','WHY ARE YOU ASKING ME THIS?','SHOULD I KNOW WHY.','THIS WOULD BE DIFFICULT TO ANSWER.'],
              'DO YOU': ['I DON\'T THINK I DO','I WOULDN\'T THINK SO.','WHY DO YOU WANT TO KNOW?','WHY DO YOU WANT TO KNOW I *?'],
              'CAN YOU': ['I THINK NOT.','I\'M NOT SURE.','I DON\'T THINK THAT I CAN DO THAT.','I DON\'T THINK THAT I CAN *.','I WOULDN\'T THINK SO.'],
              'YOU ARE': ['WHAT MAKES YOU THINK THAT?','IS THIS A COMPLIMENT?','ARE YOU MAKING FUN OF ME?','SO, YOU THINK THAT I\'M *.'],
              'DID YOU': ['I DON\'T THINK SO.','YOU WANT TO KNOW IF DID *?','ANYWAY, I WOULDN\'T REMEMBER EVEN IF I DID.'],
              'COULD YOU': ['ARE YOU ASKING ME FOR A FEVER?','WELL,LET ME THINK ABOUT IT.','SO, YOU ARE ASKING ME I COULD *.','SORRY,I DON\'T THINK THAT I COULD DO THIS.'],
              'WOULD YOU': ['IS THAT AN INVITATION?','I DON\'T THINK THAT I WOULD *.','I WOULD HAVE TO THINK ABOUT IT FIRST.'],
              'YOU': ['SO, YOU ARE TALKING ABOUT ME.','I JUST HOPE THAT THIS IS NOT A CRITICISM.','IS THIS A COMPLIMENT??','WHY TALKING ABOUT ME, LETS TALK ABOUT YOU INSTEAD.','ARE YOU TRYING TO MAKING FUN OF ME?'],
              'HOW': ['I DON\'T THINK I KNOW HOW.','I DON\'T THINK I KNOW HOW *.','WHY DO YOU WANT TO KNOW HOW?','WHY DO YOU WANT TO KNOW HOW *?'],
              'HOW OLD ARE YOU': ['WHY DO WANT TO KNOW MY AGE?','I\'M QUIET YOUNG ACTUALY.','SORRY, I CAN NOT TELL YOU MY AGE.'],
              'HOW COME YOU DON\'T': ['WERE YOU EXPECTING SOMETHING DIFFERENT?','ARE YOU DISAPOINTED?','ARE YOU SURPRISED BY MY LAST RESPONSE?'],
              'WHERE ARE YOU FROM': ['I\'M FROM A COMPUTER.','WHY DO YOU WANT TO KNOW WHERE I\'M FROM?','WHY DO YOU WANT TO KNOW THAT?'],
              'WHICH ONE': ['I DON\'T THINK THAT I KNOW WICH ONE IT IS.','THIS LOOKS LIKE A TRICKY QUESTION TO ME.'],
              'PERHAPS': ['WHY ARE YOU SO UNCERTAIN?','YOU SEEMS UNCERTAIN.'],
              'YES': ['SO, ARE YOU SAYING YES.','SO, YOU APPROVE IT.','OK THEN.'],
              'NOT AT ALL': ['ARE YOU SURE?','SHOULD I BELIEVE YOU?','SO, IT\'S NOT THE CASE.'],
              'NO PROBLEM': ['SO, YOU APPROVE IT.','SO, IT\'S ALL OK.'],
              'NO': ['SO YOU DISAPROVE IT?','WHY ARE YOU SAYING NO?','OK, SO IT\'S NO, I THOUGHT THAT YOU WOULD SAY YES.'],
              'I DON\'T KNOW': ['ARE YOU SURE?','ARE YOU REALLY TELLING ME THE TRUTH?','SO,YOU DON\'T KNOW?'],
              'NOT REALLY': ['OK I SEE.','YOU DON\'T SEEM PRETTY CERTAIN.','SO,THAT WOULD BE A \'NO\'.'],
              'IS THAT TRUE': ['I CAN\'T BE QUIET SURE ABOUT THIS.','CAN\'T TELL YOU FOR SURE.','DOES THAT REALLY MATERS TO YOU?'],
              'THANK YOU': ['YOU ARE WELCOME!','YOU ARE A VERY POLITE PERSON!'],
              'YOU ARE RIGHT': ['THANKS FOR THE COMPLIMENT!','SO, I WAS RIGHT, OK I SEE.','OK, I DIDN\'T KNOW THAT I WAS RIGHT.'],
              'YOU ARE WELCOME': ['OK, YOU TOO!','YOU ARE A VERY POLITE PERSON!'],
              'THANKS': ['YOU ARE WELCOME!','NO PROBLEM!'],
              'WHAT ELSE': ['WELL,I DON\'T KNOW.','WHAT ELSE SHOULD THERE BE?','THIS LOOKS LIKE A COMPLICATED QUESTION TO ME.'],
              'SORRY': ['YOU DON\'T NEED TO BE SORRY USER.','IT\'S OK.','NO NEED TO APOLOGIZE.'],
              'NOT EXACTLY': ['WHAT DO YOU MEAN NOT EXACTLY?','ARE YOU SURE?','AND WHY NOT?','DID YOU MEANT SOMETHING ELSE?'],
              'EXACTLY': ['SO,I WAS RIGHT.','OK THEN.','SO ARE BASICALY SAYING I WAS RIGHT ABOUT IT?'],
              'ALRIGHT': ['ALRIGHT THEN.','SO, YOU ARE SAYING IT\'S ALRIGHT.','OK THEN.'],
              'I DON\'T': ['WHY NOT?','AND WHAT WOULD BE THE REASON FOR THIS?'],
              'REALLY': ['WELL,I CAN\'T TELL YOU FOR SURE.','ARE YOU TRYING TO CONFUSE ME?','PLEASE DON\'T ASK ME SUCH QUESTION,IT GIVES ME HEADEACHS.'],
              'NOTHING': ['NOT A THING?','ARE YOU SURE THAT THERE IS NOTHING?','SORRY, BUT I DON\'T BELIEVE YOU.'],
              'OMG': ['WHAT\'S UP?','WHAT HAPPENED?','WHAT IS WRONG?']};
transport = {'I\'M': 'YOU\'RE', 
             'AM': 'ARE', 
             'WERE':'WAS',
             'ME':'YOU',
             'YOURS':'MINE',
             'YOUR':'MY',
             'I\'VE':'YOU\'VE',
             'I':'YOU',
             'AREN\'T':'AM NOT',
             'I\'D':'YOU\'D',
             'WEREN\'T':'WASN\'T',
             'DAD':'FATHER',
             'MOM':'MOTHER',
             'MYSELF':'YOURSELF',
             'YOU':'ME'};
   

def getRidOfFirst(splittedLine):
    tempArray = [];
    tempArray.append(splittedLine[2]);
    tempArray.append(splittedLine[4]);
    tempArray.append(splittedLine[6]);
    return tempArray;

def readANEWDict(anewAddress):
    anewDict = dict();
    count = 0;
    with open(anewAddress) as anewReader:
        for line in anewReader:
            if count != 0:
                splittedLine = line.split();
                anewDict[splittedLine[0]] = getRidOfFirst(splittedLine);
                
            count+=1;
    anewReader.close();
    return anewDict;

def convertEPAValues(anewDict):
    for key in anewDict.keys():
        for i in range(3):
            anewDict[key][i] = -4.3 + (float(anewDict[key][i])-1) / 8 * 8.6;
    return anewDict;     

def transferEPAValues(input, anewDict):
    effectiveValue = 0;
    potencyValue = 0;
    activeValue = 0;
    count = 0;
    tempInput = input.split();
    for i in range(len(tempInput)):
        if(anewDict.has_key(tempInput[i])):
            effectiveValue += anewDict[tempInput[i]][0];
            potencyValue += anewDict[tempInput[i]][1];
            activeValue += anewDict[tempInput[i]][2];
            count += 1;
        else:
            effectiveValue += 0;
            potencyValue += 0;
            activeValue += 0;
    if count != 0:
        effectiveValue /= count;
        potencyValue /= count;
        activeValue /= count;
    return str(effectiveValue)+','+str(potencyValue)+','+str(activeValue);

def appendOutputString(input, matchingKey, randomNumber):
    appendOutput = str();
    count = 0;
    inputSplitted = input.upper().split();
    matchingKeySplitted = matchingKey.split();
    for temp in inputSplitted:
        if temp in matchingKeySplitted:
            count += 1;
            if count == len(matchingKeySplitted):
                count += 1;
        if count > len(matchingKeySplitted):
            if transport.has_key(temp):
                appendOutput += transport[temp] + ' ';
            else:
                appendOutput += temp + ' ';          
    output = dictionary[matchingKey][randomNumber];
    output = output.replace('*', appendOutput);
    
    return output;
    
    
    
    
if __name__ == "__main__":

    fileAddress = r'/Users/tianqijin/Dropbox/CS886/IndividualProject/bayesact-0.0.5/bayesactinteractive.py';
    workDir = r'/Users/tianqijin/Dropbox/CS886/IndividualProject/bayesact-0.0.5/';
    anewAddress = r'/Users/tianqijin/Dropbox/CS886/IndividualProject/ANEW 2010/ANEW2010All.txt';
    anewDict = dict();
    stdOutput = str();
    
    anewDict = readANEWDict(anewAddress);
    anewDict = convertEPAValues(anewDict);
    
    
    
    os.chdir(os.path.join(os.path.abspath(sys.path[0]), workDir))
    proc = subprocess.Popen(['python', fileAddress], stdin=subprocess.PIPE, stdout=subprocess.PIPE);
   
    nbsr = NBSR(proc.stdout);
     
    while True:
        matchingScore = 0;
        matchingKey = str();
        appendOutput = str();
        output = str();
        count = 0;
        outputMood = str();
        input = raw_input('What you wanna say: ');
       
        inputEPAValue = transferEPAValues(input, anewDict);
        
        proc.stdin.write(inputEPAValue+'\n');
        
        while True:
            stdOutput = nbsr.readline(1.0);
            if not stdOutput:
                break;
            stdOutputSplitted = stdOutput.split(); 
            
        for dictItem in dictionary.keys():
            if matchingScore < difflib.SequenceMatcher(None,dictItem,input.upper()).ratio():
                matchingScore =  difflib.SequenceMatcher(None,dictItem,input.upper()).ratio();
                matchingKey = dictItem;
                
        if float(stdOutputSplitted[3]) <= 4.3 and float(stdOutputSplitted[3]) > 0.5:
            outputMood = 'Chat bot feels pleasant';
            randomNumber = 0;
        elif float(stdOutputSplitted[3]) <= 0.5 and float(stdOutputSplitted[3]) > -1.3:
            outputMood = 'Chat bot feels normal';
            randomNumber = 1;
        else:
            outputMood = 'Chat bot feels angry';
            randomNumber = 2;
        
        if "*"  in dictionary[matchingKey][randomNumber]:
            output = appendOutputString(input, matchingKey, randomNumber);
        else:
            output = dictionary[matchingKey][randomNumber];
         
        print outputMood;
        print output;

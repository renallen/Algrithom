#coding:utf-8
from numpy import *
import operator
from os import listdir
def classifyPerson():
	resultList=['not at all','in small doses','in large doses']
	percentTats=float(raw_input("percentage of time spent playing video games?"))
	ffmiles=float(raw_input("frequent flier miles earned per year?"))
	icecream=float(raw_input("liters of ice cream consumed per year?"))
	datingDataMat,datingLabels=file2matrix('datingTestSet2.txt')
	normmat,ranges,minvals=autoNorm(datingDataMat)
	inarr=array([ffmiles,percentTats,icecream])
	classifierresult=classify0((inarr-minvals)/ranges, normmat, datingLabels, 3)
	print(resultList[classifierresult-1])
def handwritingClassTest():
    hwLabels = []
    trainingFileList = listdir('trainingDigits')           #load the training set
    m = len(trainingFileList)
    trainingMat = zeros((m,1024))
    for i in range(m):
        fileNameStr = trainingFileList[i]
        fileStr = fileNameStr.split('.')[0]     #take off .txt
        classNumStr = int(fileStr.split('_')[0])
        hwLabels.append(classNumStr)
        trainingMat[i,:] = img2vector('trainingDigits/%s' % fileNameStr)
    testFileList = listdir('testDigits')        #iterate through the test set
    errorCount = 0.0
    mTest = len(testFileList)
    for i in range(mTest):
        fileNameStr = testFileList[i]
        fileStr = fileNameStr.split('.')[0]     #take off .txt
        classNumStr = int(fileStr.split('_')[0])
        vectorUnderTest = img2vector('testDigits/%s' % fileNameStr)
        classifierResult = classify0(vectorUnderTest, trainingMat, hwLabels, 3)
        print "the classifier came back with: %d, the real answer is: %d" % (classifierResult, classNumStr)
        if (classifierResult != classNumStr): errorCount += 1.0
    print "\nthe total number of errors is: %d" % errorCount
    print "\nthe total error rate is: %f" % (errorCount/float(mTest))
def img2vector(filename):
    returnVect = zeros((1,1024))
    fr = open(filename)
    for i in range(32):
        lineStr = fr.readline()
        for j in range(32):
            returnVect[0,32*i+j] = int(lineStr[j])
    return returnVect
#约会网站分类器
def datingClassTest():
    hoRatio = 0.50      #hold out 10%
    datingDataMat,datingLabels = file2matrix('datingTestSet2.txt')       #load data setfrom file
    normMat, ranges, minVals = autoNorm(datingDataMat)
    m = normMat.shape[0]
    numTestVecs = int(m*hoRatio)
    errorCount = 0.0
    for i in range(numTestVecs):
        classifierResult = classify0(normMat[i,:],normMat[numTestVecs:m,:],datingLabels[numTestVecs:m],3)
        print "the classifier came back with: %d, the real answer is: %d" % (classifierResult, datingLabels[i])
        if (classifierResult != datingLabels[i]): errorCount += 1.0
    print "the total error rate is: %f" % (errorCount/float(numTestVecs))
    print errorCount
#归一化数值
def autoNorm(dataSet):
    minVals = dataSet.min(0)
    maxVals = dataSet.max(0)
    ranges = maxVals - minVals
    normDataSet = zeros(shape(dataSet))
    m = dataSet.shape[0]
    normDataSet = dataSet - tile(minVals, (m,1))
    normDataSet = normDataSet/tile(ranges, (m,1))   #element wise divide
    return normDataSet, ranges, minVals
def file2matrix(filename):
    fr = open(filename)
    numberOfLines = len(fr.readlines())         #get the number of lines in the file
    returnMat = zeros((numberOfLines,3))        #prepare matrix to return
    classLabelVector = []                       #prepare labels return   
    fr = open(filename)
    index = 0
    for line in fr.readlines():
        line = line.strip()
        listFromLine = line.split('\t')
        returnMat[index,:] = listFromLine[0:3]
        classLabelVector.append(int(listFromLine[-1]))
        index += 1
    return returnMat,classLabelVector
def classify0(inx,dataset,labels,k):
	#计算距离
	datasetsize=dataset.shape[0]
	diffmat=tile(inx, (datasetsize,1))-dataset
	sqdiffmat=diffmat**2
	sqdistances=sqdiffmat.sum(axis=1)
	distances=sqdistances**0.5
	sortedDistIndicies=distances.argsort()
	classcount={}
	for i in range(k):
		voteIlabel=labels[sortedDistIndicies[i]]
		classcount[voteIlabel]=classcount.get(voteIlabel,0)+1
	sortedclasscount=sorted(classcount.iteritems(),key=operator.itemgetter(1),reverse=True)
	return sortedclasscount[0][0]

def createDataSet():
	group=array([[1.0,1.1],[1.0,1.0],[0,0],[0,0.1]])
	labels=['A','A','B','B']
	return group,labels
def test1():
	group,labels=createDataSet()
	print(classify0([0,0],group,labels,3))
def test2():
	datingDatamat,datinglabels=file2matrix('datingTestSet.txt')
def main():
	test1()
	test2()
if __name__ == '__main__':
	main()
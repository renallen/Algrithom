#coding=utf-8

import numpy as np
def standRegress(xArr,yArr):
	xTx=np.dot(xArr.T, xArr)
	if np.linalg.det(xTx)==0.0:
		print ""
		return
	w=np.dot(np.linalg.inv(xTx), np.dot(xArr.T, yArr))
	print(w)
	return w
def main():
	x=np.array([1,2,3,4,5,6])
	y=np.array([2,5,8,6,4,10])
	standRegress(x, y)
if __name__ == '__main__':
	main()

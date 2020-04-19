import cv2
import imutils
import math
import os
#hog = cv2.HOGDescriptor()
#hog.setSVMDetector(cv2.HOGDescriptor_getDefaultPeopleDetector())
face_model = cv2.CascadeClassifier('haarcascade_fullbody.xml')
cap = cv2.VideoCapture("aa.avi")
def faceCapture(username):

    dir_loc = "Images/"
    dir_path = os.path.join(dir_loc, username)
    path= os.mkdir(dir_path)

    #vid = cv2.VideoCapture("aa.avi")

    #ret, frame = vid.read()
    text1= 'ALERT: CLOSE! CLOSE! CLOSE!'
    cv2.putText(image,text1,(200,50), cv2.FONT_HERSHEY_SIMPLEX, 1, (200,255,155), 3, cv2.LINE_AA)
    filename = "Images/"+ username +"/%d.jpg"  # You need to create a images directory in ur WorkSpace.
    cv2.imwrite(filename, image)
t=str(0)
while cap.isOpened():
    # Reading the video stream

    ret, image = cap.read()
    if ret:
        '''image = imutils.resize(image,width=min(600, image.shape[1]))

        # Detecting all the regions
        # in the Image that has a
        # pedestrians inside it
        (Cor, _) = hog.detectMultiScale(image, winStride=(4, 4),padding=(4, 4),scale=1.05)
        l = len(Cor)'''
        Cor= face_model.detectMultiScale(image)
        l = len(Cor)
        #text1= 'TOTAL: '+ str(l)
        #cv2.putText(image,text1,(400,50), cv2.FONT_HERSHEY_SIMPLEX, 1, (200,255,155), 3, cv2.LINE_AA)
        s1=[]
        s2=[]
        #r=40

        #rad=80
        # Drawing the regions in the
        # Image
        if len(Cor) == 0:
            pass
        else:
            for i in range (l):
                x1  = Cor[i][0]
                y1 =  Cor[i][1]
                x2 = x1 + Cor[i][2]
                y2 = y1 + Cor[i][3]
                c1=int((x1+x2)/2)
                c2=int((y1+y2)/2)
                s1.append(c1)
                s2.append(c2)
                #print(i)
                #print(c1[i])
                #print(c1)
                #print(c2)
                '''ft = 36
                xinc=int(x2-x1)/2
                yinc=int(y2-y1)/2
                radius = math.sqrt((xinc*xinc) + (yinc*yinc))
                radius = radius+ft
                rad= radius+radius'''
                radius=36
                rad=36+36
                image = cv2.rectangle(image , (x1,  y1) , (x2, y2), [0,255,0], 3)
                image1 = cv2.circle(image, (c1,  c2), int(radius), [0,0,255], 2, 3)
                #photo[c1:c1+10]=[255,0,0]
                image[c2:c2+5,c1:c1+5]=[255,0,0]
                for j in range(len(s1)):
                    for i in range(len(s1)):
                        #center_coordinates=(s1[j],s2[j])
                        #image= cv2.circle(image, center_coordinates, r, (0, 0, 255),2)
                        if i==j:
                            pass
                        else:
                            distance = math.sqrt( ((s1[j]-s1[i])**2)+((s2[j]-s2[i])**2) )
                            print(distance)
                            #print(j)
                            #print(i)
                            if distance<rad:
                                print("CLOSE! CLOSE!")
                                faceCapture("RINKUIIIIIvjhvahbckAMHBKHBKBTCIKFHDBKSNlvJXHVKX"+t)
                                x=int(t)
                                #print("valuet",t)
                                #print("valuex",x)
                                #print(type(x))
                                x+=1
                                t=str(x)
                                image= cv2.circle(image, (s1[j],s2[j]), radius, (255, 0, 0),2)
                                image= cv2.circle(image, (s1[i],s2[i]), radius, (255, 0, 0),2)
#photo[int(((face_cor[i][1])+((face_cor[i][1]) + face_cor[i][3]))/2):int(((face_cor[i][1])+((face_cor[i][1]) + face_cor[i][3]))/2)+5]=[255,0,0]
        # Showing the output Image
        cv2.imshow("Image", image)
        if cv2.waitKey(10)==13:
            break
    else:
        break

cap.release()
cv2.destroyAllWindows()

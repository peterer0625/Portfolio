# -*- coding: utf-8 -*-
"""
Created on Wed Feb 28 17:02:30 2018

@author: KT
"""

import tensorflow as tf
import numpy as np

def getData(file_name, batch_x, batch_y):
    file = None
    try:
        file = open(file_name, "r")
        lines = file.readlines()
    except:
        print("File error")
    finally:
        file.close()

    for i in range(len(lines)):    
        #print(lines[i])
        try:
            x_ = [float(x_) / 100.0 for x_ in lines[i].split(' ') if x_.strip()]
            y_ = [x_[len(x_) - 1]]
            del x_[len(x_) - 1]
            batch_x.append(x_)
            batch_y.append(y_)
            x_ = np.asarray(x_)
            y_ = np.asarray(y_)
        except:
            print("Error:" + lines[i])

    
def function1():
    tf.reset_default_graph()
    sess = tf.InteractiveSession()
    
    x = tf.placeholder(tf.float32, [None, 20])
    y_hat = tf.placeholder(tf.float32, [None, 1])
    
    w1 = tf.Variable(tf.random_normal([20, 150]))
    b1 = tf.Variable(tf.zeros([150]))
    z1 = tf.matmul(x, w1) + b1
    a1 = tf.nn.relu(z1)
    
    w2 = tf.Variable(tf.random_normal([150, 1]))
    b2 = tf.Variable(tf.zeros([1]))
    z2 = tf.matmul(a1, w2) + b2
    a2 = tf.nn.relu(z2)
    
    y = a2
    
    loss = tf.reduce_mean(tf.reduce_sum(tf.square(y_hat * 100.0 - y * 100.0), reduction_indices=[1]))
    train_step = tf.train.AdagradOptimizer(0.002).minimize(loss)
    
    tf.initialize_all_variables().run()
    
    batch_x = []
    batch_y = []
    
    getData("2105_2017.txt", batch_x, batch_y)
    getData("2105_2016.txt", batch_x, batch_y)
    getData("2105_2015.txt", batch_x, batch_y)
    
    batch_x = np.asarray(batch_x)
    batch_x = batch_x.astype("f")
    
    batch_y = np.asarray(batch_y)
    batch_y = batch_y.astype("f")
    
    print(batch_x.shape)
    
    #print(batch_x.shape)
    #print(batch_y.shape)
    #print(batch_x.dtype)
    #print(batch_y)
    
    saver = tf.train.Saver()
    saver.restore(sess, "D:\\GitHub\\Portfolio\\Python\\StockEstimate\\StockEstimate1.ckpt")
    
    loss_value = 0;
    previous_loss_value = 0;
    count = 0;
    for i in range(10000):
        train_step.run({x: batch_x, y_hat: batch_y})  
        loss_value = loss.eval({x: batch_x, y_hat: batch_y})
        
        if loss_value == previous_loss_value:
            count = count + 1
            if count >= 30:
                break
        else:
            count = 0
        
        previous_loss_value = loss_value
        
        if i % 1000 == 0:
            saver.save(sess, "D:\\GitHub\\Portfolio\\Python\\StockEstimate\\StockEstimate1.ckpt")
            print(loss_value)
        
        #print(y.eval({x: batch_x, y_hat: batch_y}))
        #print(w1.eval()[0])
    
    for i in range(10):
        test = batch_x[i].reshape([1, 20])
        print (str(y.eval({x: test})) + " " +  str(batch_y[i]))
    
    test = np.array([50.8, 51, 51.3, 50.9, 49.4, 49.1, 49, 47.4, 48.95, 50, 49.6, 50.4, 50.5, 50.2, 50, 49.75, 49.1, 49.2, 49.05, 49.2])
    test = test / 100.0
    test = test.reshape([1, 20])
    print (str(y.eval({x: test})))

def function2():
    tf.reset_default_graph()
    sess = tf.InteractiveSession()
    
    x = tf.placeholder(tf.float32, [None, 20])
    y_hat = tf.placeholder(tf.float32, [None, 1])
    
    w1 = tf.Variable(tf.random_normal([20, 50]))
    b1 = tf.Variable(tf.zeros([50]))
    z1 = tf.matmul(x, w1) + b1
    a1 = tf.nn.relu(z1)
    
    w2 = tf.Variable(tf.random_normal([50, 20]))
    b2 = tf.Variable(tf.zeros([20]))
    z2 = tf.matmul(a1, w2) + b2
    a2 = tf.nn.relu(z2)
    
    w3 = tf.Variable(tf.random_normal([20, 1]))
    b3 = tf.Variable(tf.zeros([1]))
    z3 = tf.matmul(a2, w3) + b3
    a3 = tf.nn.relu(z3)
        
    y = a3
    
    loss = tf.reduce_mean(tf.reduce_sum(tf.square(y_hat * 100.0 - y * 100.0), reduction_indices=[1]))
    train_step = tf.train.AdagradOptimizer(0.01).minimize(loss)
    
    tf.initialize_all_variables().run()
    
    batch_x = []
    batch_y = []
    
    getData("2105_2017.txt", batch_x, batch_y)
    getData("2105_2016.txt", batch_x, batch_y)
    getData("2105_2015.txt", batch_x, batch_y)
    
    batch_x = np.asarray(batch_x)
    batch_x = batch_x.astype("f")
    
    batch_y = np.asarray(batch_y)
    batch_y = batch_y.astype("f")
    
    print(batch_x.shape)
    
    #print(batch_x.shape)
    #print(batch_y.shape)
    #print(batch_x.dtype)
    #print(batch_y)
    
    saver = tf.train.Saver()
    saver.restore(sess, "D:\\GitHub\\Portfolio\\Python\\StockEstimate\\StockEstimate2.ckpt")
    
    loss_value = 0;
    previous_loss_value = 0;
    count = 0;
    for i in range(1000000):
        train_step.run({x: batch_x, y_hat: batch_y})  
        loss_value = loss.eval({x: batch_x, y_hat: batch_y})
        
        if loss_value == previous_loss_value:
            count = count + 1
            if count >= 30:
                break
        else:
            count = 0
        
        previous_loss_value = loss_value
        
        if i > 0 and i % 1000 == 0:
            saver.save(sess, "D:\\GitHub\\Portfolio\\Python\\StockEstimate\\StockEstimate2.ckpt")
            print(loss_value)
        
        #print(y.eval({x: batch_x, y_hat: batch_y}))
        #print(w1.eval()[0])
    
    for i in range(10):
        test = batch_x[i].reshape([1, 20])
        print (str(y.eval({x: test})) + " " +  str(batch_y[i]))
    
    test = np.array([50.8, 51, 51.3, 50.9, 49.4, 49.1, 49, 47.4, 48.95, 50, 49.6, 50.4, 50.5, 50.2, 50, 49.75, 49.1, 49.2, 49.05, 49.2])
    test = test / 100.0
    test = test.reshape([1, 20])
    print (str(y.eval({x: test})))

#function1()
function2()

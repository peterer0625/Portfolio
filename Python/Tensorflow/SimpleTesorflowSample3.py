# -*- coding: utf-8 -*-
"""
Created on Wed Feb 28 17:02:30 2018

@author: KT
"""

import tensorflow as tf
from tensorflow.examples.tutorials.mnist import input_data

tf.app.flags.DEFINE_string('data_dir', '/data/', 'Directory for storing data')
mnist = input_data.read_data_sets(tf.app.flags.FLAGS.data_dir, one_hot = True)

sess = tf.InteractiveSession()

x = tf.placeholder(tf.float32, [None, 784])

w1 = tf.Variable(tf.random_normal([784, 200]))
b1 = tf.Variable(tf.zeros([200]))
z1 = tf.matmul(x, w1) + b1
a1 = tf.nn.relu(z1)

w2 = tf.Variable(tf.zeros([200, 10]))
b2 = tf.Variable(tf.zeros([10]))
z2 = tf.matmul(a1, w2) + b2
a2 = tf.nn.softmax(z2)

y = a2

y_hat = tf.placeholder(tf.float32, [None, 10])
cross_entropy = tf.reduce_mean(-tf.reduce_sum(y_hat * tf.log(y), reduction_indices=[1]))
train_step = tf.train.GradientDescentOptimizer(0.005).minimize(cross_entropy)

tf.initialize_all_variables().run()
for i in range(200):
    batch_x, batch_y = mnist.train.next_batch(100)
    train_step.run({x: batch_x, y_hat: batch_y})  
    correct_prediction = tf.equal(tf.argmax(y, 1), tf.argmax(y_hat, 1))
    accuracy = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))
    print(accuracy.eval({x: mnist.test.images, y_hat: mnist.test.labels}))
    #print(w.eval())
    #print(y)
    #print(y.eval({x: mnist.test.images}))

# -*- coding: utf-8 -*-
"""
Created on Tue Feb 27 17:19:07 2018

@author: KT
"""

import tensorflow as tf
import numpy as np
import matplotlib.pyplot as plt

def add_layer(inputs, in_size, out_size, activation_function = None):
    weights = tf.Variable(tf.random_normal([in_size, out_size]))
    biases = tf.Variable(tf.zeros([1, out_size]) + 0.1)
    weights_plus_biases = tf.matmul(inputs, weights) + biases   

    if activation_function is None:
        outputs = weights_plus_biases
    else:
        outputs = activation_function(weights_plus_biases)
    return outputs

x_input = tf.placeholder(tf.float32, [None, 1])
y_input = tf.placeholder(tf.float32, [None, 1])

layer1 = add_layer(x_input, 1, 10, activation_function = tf.nn.relu)
prediction = add_layer(layer1, 10, 1, activation_function = None)

x_data = np.linspace(-1, 1, 300)[:, np.newaxis]
noise = np.random.normal(0, 0.05, x_data.shape)
y_data = np.square(x_data) - 0.5 + noise

#print(x_data)

loss = tf.reduce_mean(tf.reduce_sum(tf.square(y_input - prediction), reduction_indices=[1]))
train_step = tf.train.GradientDescentOptimizer(0.1).minimize(loss)

init = tf.initialize_all_variables()
sess = tf.Session()
sess.run(init)
#
fig = plt.figure()
ax = fig.add_subplot(1, 1, 1)
ax.scatter(x_data, y_data)

for i in range(220):
    sess.run(train_step, feed_dict={x_input: x_data, y_input: y_data})
    
    try:
        ax.lines.remove(lines[0])
    except Exception:
        pass
 
    #print(sess.run(loss, feed_dict={x_input: x_data, y_input: y_data}))
    prediction_value = sess.run(prediction, feed_dict={x_input: x_data})
    lines = ax.plot(x_data, prediction_value, 'r-', lw = 5)

plt.ion()
plt.show()

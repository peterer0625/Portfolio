# -*- coding: utf-8 -*-
"""
Created on Tue Feb 27 17:19:07 2018

@author: KT
"""

import tensorflow as tf
import numpy as np

# Initialize training data
# x = input
# y = label (answer)
x_data = np.random.rand(10).astype(np.float32)
y_data = x_data * 0.1 + 0.3

# Initialize weight
weights = tf.Variable(tf.random_uniform([1], -1.0, 1.0))

# Initialize biases
biases = tf.Variable(tf.zeros([1]))

# Calculate y from tf
y = weights * x_data + biases

# Define loss function
loss = tf.reduce_mean(tf.square(y - y_data))

# Define Optimizer
optimizer = tf.train.GradientDescentOptimizer(0.45)

# Session run
train = optimizer.minimize(loss)
init = tf.initialize_all_variables()
session = tf.Session()
session.run(init)     

for step in range(500):
    session.run(train)
    print(step, session.run(weights), session.run(biases))
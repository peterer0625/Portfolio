# -*- coding: utf-8 -*-
"""
Created on Wed Feb 28 13:43:45 2018

@author: KT
"""

import tensorflow as tf
value = tf.constant([[1],
                    [2],
                    [3],
                    [4],
                    [5],
                    [6]])
sess = tf.Session()
print(sess.run(tf.reduce_sum(tf.square(value), reduction_indices=[1])))
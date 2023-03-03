import numpy as np

x = np.array([[0, 0], [0, 1], [1, 0], [1, 1]])
y = np.array([0, 1, 1, 0])

print(np.shape(x))
print(np.shape(y))

print(len(x))
print(len(y))

print(x[1])
print(y[1])

print(x[:, 0])

print(x[-1, :])
print(y[-1])

x = 2 * x - 1
print(x)

x_row_sum = x[0, :] + x[1, :] + x[2, :] + x[3, :]

x_row_sum = np.sum(x, axis=0)
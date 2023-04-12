class Array:
    # Python arrays are only "dynamic"
    # Everytime the maximum capacity is exceeded
    # a new array is allocated with doule the capacity
    # Known as lists rather than arrays
    def __init__(self) -> None:
        __array = []
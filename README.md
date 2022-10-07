# Hoth Probe Droid

## Running
```./gradlew clean run```

## Testing
```./gradlew clean test```

## Problem Statement
The galactic empire has deployed several probe droids across the galaxy is in search of rebel
base locations. A squad of probe droids have landed on a plateau on Hoth. This plateau, which
is curiously rectangular, must be navigated by the droids so that their on-board cameras can get
a complete view of the surrounding terrain to send back to the Empire. A probe droid&#39;s position
and position is represented by a combination of x and y co-ordinates and a letter representing
one of the four cardinal compass points. The plateau is divided up into a grid to simplify
navigation. An example position might be 0, 0, N, which means the probe droid is in the bottom
left corner and facing North. In order to control a probe droid, the empire sends a simple string
of letters. The possible letters are &#39;L&#39;, &#39;R&#39; and &#39;M&#39;. &#39;L&#39; and &#39;R&#39; makes the probe droid spin 90
degrees left or right respectively, without moving from its current spot. &#39;M&#39; means move
forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

INPUT:

The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates
are assumed to be 0,0.

The rest of the input is information pertaining to the probe droids that have been deployed.
Each probe droid has two lines of input. The first line gives the probe droid&#39;s position, and the
second line is a series of instructions telling the probe droid how to explore the plateau. The
position is made up of two integers and a letter separated by spaces, corresponding to the x
and y co-ordinates and the probe droid&#39;s orientation.

Each probe droid will be finished sequentially, which means that the second probe droid won&#39;t
start to move until the first one has finished moving.

OUTPUT:

The output for each probe droid should be its final co-ordinates and heading.

INPUT AND OUTPUT:

Test Input:
```
5 5

1 2 N

LMLMLMLMM

3 3 E

MMRMMRMRRM
```
Expected Output:

```
1 3 N

5 1 E
```


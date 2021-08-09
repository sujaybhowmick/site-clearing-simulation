# Site Clearing Simulation

## Prequisites

Java 11 Runtime

## Run Tests

```bash
~/l/site-clearing-simulation$ ./gradlew clean check

BUILD SUCCESSFUL in 1s
5 actionable tasks: 5 executed
```

## Build Jar

```bash
~/l/site-clearing-simulation$ ./gradlew clean jar

BUILD SUCCESSFUL in 870ms
4 actionable tasks: 4 executed
```

## Run Simulation Program

```bash
 ~/l/site-clearing-simulation$ java -jar build/libs/site-clearing-simulation-1.0-SNAPSHOT.jar --file ./site-map-input.txt
(l)eft, (r)ight, (a)dvance <n>, (q)uit: a 4
(l)eft, (r)ight, (a)dvance <n>, (q)uit: r
(l)eft, (r)ight, (a)dvance <n>, (q)uit: a 4
(l)eft, (r)ight, (a)dvance <n>, (q)uit: l
(l)eft, (r)ight, (a)dvance <n>, (q)uit: a 2
(l)eft, (r)ight, (a)dvance <n>, (q)uit: a 4
(l)eft, (r)ight, (a)dvance <n>, (q)uit: l
(l)eft, (r)ight, (a)dvance <n>, (q)uit: q
advance 4, turn right, advance 4, turn left, advance 2, advance 4, turn left, quit
Item                                                     Quantity       Cost
Communication overhead                                       8          8
Fuel                                                         19         19
Uncleared square at end of Simulation                        34        102
Destruction of protected trees                               0          0
Repairing paint damage to bulldozer clearable tree           2          4
---------------------------------------------------------------------------
Total                                                                  133

Thank you for using Aconex site clearing simulator
```

## Run Simulation with Extra Debug Info

```bash
~/l/site-clearing-simulation$ java -jar build/libs/site-clearing-simulation-1.0-SNAPSHOT.jar --file ./site-map-input.txt --extraInfo
(l)eft, (r)ight, (a)dvance <n>, (q)uit: a 4
(l)eft, (r)ight, (a)dvance <n>, (q)uit: r
(l)eft, (r)ight, (a)dvance <n>, (q)uit: a 4
(l)eft, (r)ight, (a)dvance <n>, (q)uit: l
(l)eft, (r)ight, (a)dvance <n>, (q)uit: a 2
(l)eft, (r)ight, (a)dvance <n>, (q)uit: a 4
(l)eft, (r)ight, (a)dvance <n>, (q)uit: l
(l)eft, (r)ight, (a)dvance <n>, (q)uit: q
{Cell Type:o, Coordinates (x, y):(0, 0)}, Orientation: E
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
{Cell Type:o, Coordinates (x, y):(4, 9)}, Orientation: N
[{Cell Type:o, Coordinates (x, y):(0, 0)}, {Cell Type:o, Coordinates (x, y):(0, 1)}, {Cell Type:t, Coordinates (x, y):(0, 2)}, {Cell Type:o, Coordinates (x, y):(0, 3)}, {Cell Type:o, Coordinates (x, y):(1, 3)}, {Cell Type:o, Coordinates (x, y):(2, 3)}, {Cell Type:r, Coordinates (x, y):(3, 3)}, {Cell Type:r, Coordinates (x, y):(4, 3)}, {Cell Type:r, Coordinates (x, y):(4, 4)}, {Cell Type:t, Coordinates (x, y):(4, 5)}, {Cell Type:o, Coordinates (x, y):(4, 6)}, {Cell Type:o, Coordinates (x, y):(4, 7)}, {Cell Type:o, Coordinates (x, y):(4, 8)}, {Cell Type:o, Coordinates (x, y):(4, 9)}]
advance 4, turn right, advance 4, turn left, advance 2, advance 4, turn left, quit
Item                                                     Quantity       Cost
Communication overhead                                       8          8
Fuel                                                         19         19
Uncleared square at end of Simulation                        34        102
Destruction of protected trees                               0          0
Repairing paint damage to bulldozer clearable tree           2          4
---------------------------------------------------------------------------
Total                                                                  133

Thank you for using Aconex site clearing simulator
```


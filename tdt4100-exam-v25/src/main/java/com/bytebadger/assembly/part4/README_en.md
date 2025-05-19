# Part 4 - Inheritence (15%)

The JavaDoc in the classes below contains details to understand the requirements of this task and complete the implementation of both classes.

Relevant keywords:
* Super and subclasses
* Hierarchy

## Task - A structured part hierarchy

The computer parts are organized into categories in a hierarchy (e.g. the 'Keyboard' category is within the 'Input devices' category, which again is within the 'All parts' category). As an illustration, when navigating the part catalogue, the categories should be organized in a structure like this, with all categories as subcategories (in some way or another) of one single parent category:

```plaintext

- All parts
    - Input devices
        - Keyboard
        - Mouse
        - Scanner
        - Game controller
    - Processing unit
        - CPU
        - Motherboard
    - Storage devices
        - Hard disk drive
        - Solid state drive
        - RAM
    - Output devices
        - Monitor
        - Printer
        - Speakers
    - Power and cooling
        - PSU
        - Cooling fans
    ...

```

As an example in this hierarchy, "Processing unit" is the *parent* of both "CPU" and "Motherboard". Further, both "All parts" and "Input devices" are *ancestors* of "Keyboard" and "Mouse", since they are a parent of their parent, and so on.

Implement this type of category hierarchy through the [PartCategory.java](PartCategory.java) class according to JavaDoc.

## Unit tests

A complete set of unit tests is supplied to support you for this part.

* [Tests for PartCategory](../../../../../../test/java/com/bytebadger/assembly/part4/PartCategoryTest.java)
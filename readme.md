# Babashka-Based CV Builder

My Google Docs CV was becoming difficult to manage. I started with a single document that quickly mushroomed into several, as I had to make it relevant for each position I was applying to. The problem was that whenever I wrote something or found a grammar issue, I had to update it in all the versions, and it was getting a bit messy.

This is the setup I came up with:

I start with a single `resume.yaml` file, which gives me the feel of a document that I can read "as a human" while still being machine-readable. I chose YAML over other formats like Markdown because it's easier to parse into structured data.

In this `resume.yaml` file, I can comment out specific parts, making it easier to propagate changes compared to a WYSIWYG editor. Additionally, version control gives me the diff, making it easy to review changes and avoid nasty surprises.

I used this [figma template](https://www.figma.com/community/file/1230670384525015423/Just-Another-Resume-Template) with [locofy.ai](locofy.ai) to generate the markup and Tailwind configuration.

Then I turned the markup into Hiccup and used Babashka tasks as a build tool.

## Build
The server needs to be running first:

```
bb dev
```

then,

```
bb builds-everything-once
```

## Check it

```
bb dev
```

Then visit [localhost:1337](http://localhost:1337)

## Print to PDF

`bb builds-everything-once` prints to `pdf/resume.pdf` using `Puppeteer`.

## Watch

```
bb watch-everything
```

## Release

```
RELEASE=TRUE bb builds-everything-once
```

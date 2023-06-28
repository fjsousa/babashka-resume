# babashka based CV builder

My Google Docs CV was becoming difficult to manage. I started with a single document that quickly mushroomed into several, as I had to make it relevant for each position I was applying for. The problem was that whenever I wrote something or found a grammar issue, I had to update it in all the versions. It was getting difficult to manage.

This is the setup I came up with:

I have a single resume.yaml because it gives me the feel of a CV that I can read "as a human" while still being machine-readable. I chose YAML over Markdown, for example, because it offers richer features.

In this resume.yaml file, I can comment out specific parts, making it easier to propagate changes compared to a WYSIWYG editor.

I used this [figma template](https://www.figma.com/community/file/1230670384525015423/Just-Another-Resume-Template) with [locofy.ai](locofy.ai) to generate the markup and Tailwind configuration.

Then I turned the markup into Hiccup and used babashka tasks as a build tool.

## build

```
bb builds-everything-once
```

## check it

```
bb dev
```

Then [localhost:1337](http://localhost:1337)


## print to PDF


`bb builds-everything-once` prints to `pdf/resume.pdf` using `Puppeteer`.

## Watch

```
bb watch-everything
```

## Release

```
RELEASE=TRUE bb builds-everything-once
```

### Cheatsheet

<table><thead><tr><th align="left">What</th>
  <th align="left">Inline Markdown</th>
  <th align="left">Reference Markdown</th>
  <th align="left">HTML Tags</th>
</tr></thead><tbody><tr><td align="left">link</td>
  <td align="left"><code>[linked text][id]</code></td>
  <td align="left"><code>[id]: URL "title"</code></td>
  <td align="left"><code>a</code></td>
</tr><tr><td align="left">link</td>
  <td align="left"><code>[linked text][]</code></td>
  <td align="left"><code>[linked text]: URL "title"</code> &nbsp;&nbsp;</td>
  <td align="left"><code>a</code></td>
</tr><tr><td align="left">image</td>
  <td align="left"><code>![alt text][id]</code></td>
  <td align="left"><code>[id]: URL "title"</code></td>
  <td align="left"><code>img</code></td>
</tr><tr><td align="left">footnote &nbsp;&nbsp;</td>
  <td align="left"><code>footnoted text[^id]</code> &nbsp;&nbsp;</td>
  <td align="left"><code>[^id]: the footnote</code></td>
  <td align="left"><code>sup a</code></td>
</tr><tr><td align="left">abbr</td>
  <td align="left"><code>definitium</code></td>
  <td align="left"><code>*[definitium]: definition</code></td>
  <td align="left"><code>abbr</code></td>
</tr><tr><td align="left">&nbsp;</td>
  <td align="left">&nbsp;</td>
  <td align="left">&nbsp;</td>
  <td align="left">&nbsp;</td>
</tr></tbody></table>

---

*Link definitions are hidden*

[eclipse-official]: 	http://www.eclipse.org
[actorclass-feature]: 	feature_reference.html#actorclass "Link Title (Hover)"
[test-heading-id]: 		#test-heading "Test Heading (Hover)"

```
[eclipse-official]: http://www.eclipse.org
[actorclass-feature]: feature_reference.html#actorclass "Link Title (Hover)"
[test-heading-id]: #test-heading "Test Heading (Hover)"
```

---

[eclipse.org with title](http://www.eclipse.org "Link Title (Hover)")
[eclipse.org no title](http://www.eclipse.org)
[eclipse.org ref][eclipse-official]
[ActorClass][actorclass-feature]
[[ActorClass]]

# Test Heading

</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>

[Test Heading direct](#test-heading)
[Test Heading ref][test-heading-id]


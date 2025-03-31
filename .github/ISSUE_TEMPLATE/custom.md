---
name: Custom issue template
about: 체크리스트 이슈 템플릿
title: ''
labels: ''
assignees: ''

---

name: Feature Request
description: 새로운 기능 요청
labels: enhancement
body:
  - type: markdown
    attributes:
      value: "## 🚀 새로운 기능 요청"

  - type: textarea
    id: description
    attributes:
      label: "설명"
      description: "이 기능에 대한 간단한 설명을 작성하세요."

  - type: checkboxes
    id: tasks
    attributes:
      label: "할 일 체크리스트"
      options:
        - label: "UI 디자인"
        - label: "백엔드 API 연결"
        - label: "테스트 코드 작성"
